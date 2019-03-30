package o2o.web.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/frontend")
public class FrontendController {
	@RequestMapping(value = "/mainPage", method = RequestMethod.GET)
	private String showMainPage() {
		return "frontend/mainPage";
	}

	@RequestMapping(value = "/productDetail", method = RequestMethod.GET)
	private String showProductDetail() {
		return "frontend/productDetail";
	}

	@RequestMapping(value = "/shopDetail", method = RequestMethod.GET)
	private String showShopDetail() {
		return "frontend/shopDetail";
	}

	@RequestMapping(value = "/shopList", method = RequestMethod.GET)
	private String showShopList() {
		return "frontend/shopList";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	private String index() {
		return "frontend/index";
	}

	@RequestMapping(value = "/myPoint", method = RequestMethod.GET)
	private String myPoint() {
		return "frontend/myPoint";
	}

	@RequestMapping(value = "/myRecord", method = RequestMethod.GET)
	private String myRecord() {
		return "frontend/myRecord";
	}

	@RequestMapping(value = "/pointRecord", method = RequestMethod.GET)
	private String pointRecord() {
		return "frontend/pointRecord";
	}

	@RequestMapping(value = "/awardDetail", method = RequestMethod.GET)
	private String awardDetail() {
		return "frontend/awardDetail";
	}

	@RequestMapping(value = "/customerBind", method = RequestMethod.GET)
	private String customerBind() {
		return "frontend/customerBind";
	}
}
