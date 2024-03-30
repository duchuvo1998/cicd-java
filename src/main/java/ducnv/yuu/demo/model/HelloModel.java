package ducnv.yuu.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class HelloModel {
	private String helloText;
	
	public HelloModel(){
		this.helloText = "Hello";
	};
	public HelloModel(String name){
		this.helloText = name;
	};
}
