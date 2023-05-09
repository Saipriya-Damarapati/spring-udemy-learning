package learn.restapi.restfulwebservices.filtering;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping("filtering")
	public SomeBean filtering() {
		return new SomeBean("value1", "value2", "value3");
	}
	
	@GetMapping("filtering-list")
	public List<SomeBean> filteringList() {
		return List.of(new SomeBean("value01", "value02", "value03"),
						new SomeBean("value11", "value12", "value13"),
						new SomeBean("value21", "value22", "value23"));
	}
}
