package com.unisource.universitysource.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class NoteResponseJsonSerializer {
    public static class NoteSerializer extends JsonSerializer<NoteResponse> {

        @Override
        public void serialize(NoteResponse noteResponse, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("noteId", noteResponse.getNoteId());
            jsonGenerator.writeStringField("course", noteResponse.getCourse().getCourseName());
            jsonGenerator.writeStringField("writer", noteResponse.getWriter());
            jsonGenerator.writeStringField("uploader", noteResponse.getUploader().getUserName());
            jsonGenerator.writeStringField("fileName", noteResponse.getFileName());
            jsonGenerator.writeStringField("fileType", noteResponse.getFileType());
            jsonGenerator.writeNumberField("likes", noteResponse.getLikes());
            jsonGenerator.writeArrayFieldStart("tags");
            for (Tag tag : noteResponse.getTags()) {
                jsonGenerator.writeObject(tag);
            }
            jsonGenerator.writeEndArray();
            jsonGenerator.writeEndObject();
        }
    }
}
