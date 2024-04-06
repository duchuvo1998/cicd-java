package ducnv.yuu.demo.exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import ducnv.yuu.demo.service.ServerInfoService;
import ducnv.yuu.demo.util.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	private ServerInfoService serverInfoService;
	
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGlobalException(Exception ex, WebRequest request, Object ob,Object ob2 ) {
    	ApiResponse response =  new ApiResponse(HttpStatus.BAD_REQUEST.value(), "Undefined");
    	if (ex instanceof NoResourceFoundException) {
    		NoResourceFoundException childException = (NoResourceFoundException) ex;
    		String resourcePath = childException.getResourcePath();
    		int status = childException.getBody().getStatus();
    		String message = "[" + serverInfoService.getServerUrl()+ "/" + resourcePath + "/] is not found";
    		response = new ApiResponse(status, message);
    	}
		
		return ResponseEntity.ok(response);
    }
}
