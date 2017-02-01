package pl.java.scalatech.es;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BaseEvent {

	private String id;

	private String type;

	private String entity;

	private String entityId;

	private LocalDateTime createdDate;

	private String txId;

	private String userId;
}