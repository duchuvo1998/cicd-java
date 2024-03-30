package ducnv.yuu.demo.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    private int status;
    private String message;
    private Object data;

    public ApiResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    
    public ApiResponse(Object data) {
        this.status = 0;
        this.message = "";
        this.data = data;
    }
    
    public ApiResponse(String message) {
        this.status = 0;
        this.message = message;
        this.data = null;
    }
}
