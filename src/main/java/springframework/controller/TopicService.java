package springframework.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			new Topic("java", "javascript", "javascript description"),
			new Topic("html", "Html 5", "Html 5 description"), new Topic("CSDL", "Name CSDL", "Csdl description")));

	public List<Topic> getAllTopic() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			Topic tp = new Topic();
			if (topics.get(i).getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
//		for (int i = 0; i < topics.size(); i++) {
//			if (topics.get(i).getId().equals(id))
//				topics.remove(i);
//			return;
//		}
		topics.removeIf(t -> t.getId().equals(id)); // master
	}
}
