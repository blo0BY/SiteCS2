package com.grenade.feedback;

import org.springframework.web.bind.annotation.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    private static final String FILE_PATH = "/home/blo0by/feedbacks.txt"; // Или другой путь, если нужно

    @PostMapping
    public String createFeedback(@RequestBody Feedback feedback) {
        feedback.setCreatedAt(LocalDateTime.now());

        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(String.format(
                "Время: %s%nИмя: %s%nEmail: %s%nСообщение: %s%n------------------------%n",
                feedback.getCreatedAt(),
                feedback.getName(),
                feedback.getEmail(),
                feedback.getMessage()
            ));
        } catch (IOException e) {
            e.printStackTrace();
            return "Ошибка при сохранении данных";
        }

        return "Данные успешно сохранены";
    }
}
