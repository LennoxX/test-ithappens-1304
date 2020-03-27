package com.teste.ithappens.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Classe utilizada para enviar os dados via JSON
 */
public class Response<T> {

	private T data;

	private List<String> errors;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<String> getErrors() {
		if (this.errors == null) {
			this.errors = new ArrayList<>();
		}

		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}