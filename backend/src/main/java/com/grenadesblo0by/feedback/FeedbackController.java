package com.grenade.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
	@Autowired
	private FeedbackRepository feedbackRepository;

	@PostMapping
	public Feedback createFeedback(@RequestBody Feedback feedback) {
		feedback.setCreatedAt(LocalDateTime.now());
		return feedbackRepository.save(feedback);
	}
}