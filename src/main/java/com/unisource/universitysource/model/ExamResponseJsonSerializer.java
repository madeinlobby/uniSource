package com.unisource.universitysource.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class ExamResponseJsonSerializer {
    public static class ExamResponseSerializer extends JsonSerializer<ExamResponse> {

        @Override
        public void serialize(ExamResponse examResponse, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("examId", examResponse.getExamId());
            jsonGenerator.writeStringField("course", examResponse.getCourse().getCourseName());
            jsonGenerator.writeStringField("date", examResponse.getDate().toString());
            jsonGenerator.writeStringField("uploader", examResponse.getUploader().getUserName());
            jsonGenerator.writeStringField("fileName", examResponse.getFileName());
            jsonGenerator.writeStringField("fileType", examResponse.getFileType());
            jsonGenerator.writeNumberField("likes", examResponse.getLikes());
            jsonGenerator.writeArrayFieldStart("tags");
            for (Tag tag : examResponse.getTags()) {
                jsonGenerator.writeObject(tag);
            }
            jsonGenerator.writeEndArray();
            jsonGenerator.writeEndObject();
        }
    }
}
