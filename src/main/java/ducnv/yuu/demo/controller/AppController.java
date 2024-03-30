package ducnv.yuu.demo.controller;

import ducnv.yuu.demo.model.HelloModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tesst")
public class AppController extends BaseController{
	@GetMapping("hello")
	public HelloModel getHello() {
		HelloModel helloModel = new HelloModel();
		return helloModel;
	}
}
