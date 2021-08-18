package com.encora.dreambox.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;

@Order(1)
public class TokenRequestFilter implements Filter {

	private String tokenProperty;

	public TokenRequestFilter() {

	}

	public TokenRequestFilter(String token) {
		this.tokenProperty = token;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		String token = req.getHeader("token");

		if (token != null && token.equals(tokenProperty)) {
			chain.doFilter(request, response);
		} else {
			HttpServletResponse resp = (HttpServletResponse) response;
			String error = "Invalid or no present token";
			resp.reset();
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setContentLength(error.length());
			response.getWriter().write(error);
		}
	}
}
