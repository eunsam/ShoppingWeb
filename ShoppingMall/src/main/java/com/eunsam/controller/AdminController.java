package com.eunsam.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eunsam.domain.CategoryVO;
import com.eunsam.domain.GoodsVO;
import com.eunsam.domain.GoodsViewVO;
import com.eunsam.domain.OrderListVO;
import com.eunsam.domain.OrderVO;
import com.eunsam.service.AdminService;
import com.eunsam.utils.UploadFileUtils;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService adminService;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	//관리자화면
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void getIndex() throws Exception {
		logger.info("get index");
	}
	
	//상품 등록 - GET
	@RequestMapping(value = "/goods/register", method = RequestMethod.GET)
	public void getGoodsRegister(Model model) throws Exception {
		logger.info("get goods register");
		
		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}
	
	//상품 등록 - POST
	@RequestMapping(value = "/goods/register", method = RequestMethod.POST)
	public String postGoodsRegister(GoodsVO vo, MultipartFile file) throws Exception {
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload"; 
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			//파일 인풋박스에 파일 이름이 있다면
			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		
			vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);	
			
		} else {fileName = File.separator + "images" + File.separator + "none.jpg";
		
		vo.setGdsImg(fileName);
		vo.setGdsThumbImg(fileName);
		}
		
		adminService.register(vo);
		
		return "redirect:/admin/index";
	}
	
	//상품 목록
	@RequestMapping(value = "/goods/list", method = RequestMethod.GET)
	public void getGoodsList(Model model) throws Exception {
		logger.info("get goods list");
		List<GoodsViewVO> list = adminService.goodslist();
		model.addAttribute("list", list);
	}
	
	//상품 조회
	@RequestMapping(value = "/goods/view", method = RequestMethod.GET)
	public void getGoodsView(@RequestParam("n") int gdsNum, Model model) throws Exception {
		logger.info("get goods view");
		GoodsViewVO goods = adminService.goodsView(gdsNum);
		model.addAttribute("goods", goods);
	}
	
	//상품 수정 - get
	@RequestMapping(value = "/goods/modify", method = RequestMethod.GET)
	public void getGoodsModify(@RequestParam("n") int gdsNum, Model model) throws Exception {
		logger.info("get goods modify");
		
		GoodsViewVO goods = adminService.goodsView(gdsNum);
		model.addAttribute("goods", goods);
		
		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}
	
	//상품 수정 - post
	@RequestMapping(value = "/goods/modify", method = RequestMethod.POST)
	public String postGoodsModify(GoodsVO vo, MultipartFile file, HttpServletRequest req) throws Exception {
		logger.info("post goods modify");
		//새로운 파일이 등록되었는지 확인
		if(file.getOriginalFilename() != null && !file.getOriginalFilename().equals("")) {
			//기존 파일 삭제
			new File(uploadPath + req.getParameter("gdsImg")).delete();
			new File(uploadPath + req.getParameter("gdsThumbImg")).delete();
			
			//새 파일 등록
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			
			vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
			
		} else { //새 파일이 없으면
			//기존 이미지 사용
			vo.setGdsImg(req.getParameter("gdsImg"));
			vo.setGdsThumbImg(req.getParameter("gdsThumbImg"));
		}
		
		adminService.goodsModify(vo);
		return "redirect:/admin/index";
	}
	
	//상품 삭제
	@RequestMapping(value = "/goods/delete", method = RequestMethod.POST)
	public String postGoodsDelete(@RequestParam("n") int gdsNum) throws Exception {
		logger.info("post goods delete");
		adminService.goodsDelete(gdsNum);
		return "redirect:/admin/index";
	}
	
	//ck에디터에서 이미지 업로드
	@RequestMapping(value = "/goods/ckUpload", method = RequestMethod.POST)
	public void postCKEditorImgUpload(HttpServletRequest req, 
			HttpServletResponse res, @RequestParam MultipartFile upload) throws Exception {
		logger.info("post CKEditor img upload");
		
		//중복 방지 랜덤파일명 생성
		UUID uid = UUID.randomUUID();
		
		OutputStream out = null;
		PrintWriter printWriter = null;
		
		//인코딩
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		try {
			String fileName = upload.getOriginalFilename();
			byte[] bytes = upload.getBytes();
			
			//업로드 경로
			String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uid + "_" + fileName; 
		
			out = new FileOutputStream(new File(ckUploadPath));
			out.write(bytes);
			out.flush(); //out에 저장된 데이터를 전송하고 초기화
			
			String callback = req.getParameter("CKEditorFuncNum");
			printWriter = res.getWriter();
			String fileUrl = "/ckUpload/" + uid + "_" + fileName; //작성 화면
			
			//업로드시 메시지 출력
			printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
			
			printWriter.flush();
			
		} catch (IOException e) { e.printStackTrace();
		} finally {
			try {
				if(out != null) { out.close(); }
				if(printWriter != null) { printWriter.close();}	
			} catch(IOException e) { e.printStackTrace(); }	
			}	
			
			return;
			
	}
	
	//주문 목록
	@RequestMapping(value = "/shop/orderList", method = RequestMethod.GET)
	public void getOrderList(Model model) throws Exception {
		logger.info("get order list");
		
		List<OrderVO> orderList = adminService.orderList();
		
		model.addAttribute("orderList", orderList);
	}
	
	//특정 주문 목록
	@RequestMapping(value = "/shop/orderView", method = RequestMethod.GET)
	public void getOrderView(@RequestParam("n") String orderId,
			OrderVO order, Model model) throws Exception {
		logger.info("get order view");
		
		order.setOrderId(orderId);
		List<OrderListVO> orderView = adminService.orderView(order);
		
		model.addAttribute("orderView", orderView);
	}
	
}

