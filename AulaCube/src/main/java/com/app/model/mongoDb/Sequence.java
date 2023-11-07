package com.app.model.mongoDb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequence")
public class Sequence {
    @Id
    private String id;
    private long seq;
	/**
	 * 
	 */
	public Sequence() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param seq
	 */
	public Sequence(String id, long seq) {
		super();
		this.id = id;
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
	@Override
	public String toString() {
		return "Sequence [id=" + id + ", seq=" + seq + "]";
	}
    
    
}
