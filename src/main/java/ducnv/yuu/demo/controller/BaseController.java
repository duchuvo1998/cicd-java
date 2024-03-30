package ducnv.yuu.demo.controller;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ducnv.yuu.demo.service.ServerInfoService;
import ducnv.yuu.demo.util.ApiResponse;

/**
 * This is a Base REST controller.
 */
@RestController
@RequestMapping("api/v1")
public abstract class BaseController {
	@Value("${api.url}/${api.version}")
	private String baseUrl;

	@Autowired
	private ServerInfoService serverInfoService;

	/**
	 * 
	 * @return 
	 */
	@GetMapping("")
    public ResponseEntity<ApiResponse> index() {
    	ApiResponse response;
    	response = new ApiResponse("[" + serverInfoService.getServerUrl()+ "/" + baseUrl + "] is not found");
		return ResponseEntity.ok(response);
    }
	
	/**
	 * 
	 * @return 
	 * @throws UnknownHostException 
	 */
	@GetMapping("/")
    public ResponseEntity<ApiResponse> index2() {
    	ApiResponse response;
		response = new ApiResponse("[" + serverInfoService.getServerUrl()+ "/" + baseUrl + "/] is not found");
		return ResponseEntity.ok(response);
    }
}
