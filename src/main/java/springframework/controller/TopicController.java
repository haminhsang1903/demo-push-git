package springframework.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topics")
public class TopicController {
	
	@Autowired
	private TopicRepository topicRepository;
	
	
	@GetMapping("")
	public List<Topic> getAllTopic() {
		return (List<Topic>) topicRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicRepository.findOne(id);
	}
	
	@PostMapping()
	public void addTopic(@RequestBody Topic topic) {
		topicRepository.save(topic);
	}
	
	//@PutMapping("{id}")
	//public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {	
	//}
	
	@DeleteMapping("{id}")
	public void deleteTopic(@PathVariable String id) {
		topicRepository.delete(id);
	}
}
