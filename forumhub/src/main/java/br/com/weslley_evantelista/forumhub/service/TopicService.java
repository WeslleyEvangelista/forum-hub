package br.com.weslley_evantelista.forumhub.service;

import br.com.weslley_evantelista.forumhub.dto.TopicDTO;
import br.com.weslley_evantelista.forumhub.exception.ResourceNotFoundException;
import br.com.weslley_evantelista.forumhub.model.Topic;
import br.com.weslley_evantelista.forumhub.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public Topic createTopic(TopicDTO topicDTO) {
        Topic topic = new Topic();
        topic.setTitle(topicDTO.getTitle());
        topic.setContent(topicDTO.getContent());
        return topicRepository.save(topic);
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Topic getTopicById(Long id) {
        return topicRepository.findById(id).orElseThrow();
    }

    public Topic updateTopic(Long id, TopicDTO topicDTO) {
        Topic topic = getTopicById(id);
        topic.setTitle(topicDTO.getTitle());
        topic.setContent(topicDTO.getContent());
        return topicRepository.save(topic);
    }

    public void deleteTopic(Long id) {
        Topic topic = getTopicById(id);
        topicRepository.delete(topic);
    }
}
