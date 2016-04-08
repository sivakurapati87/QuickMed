package com.intuiture.qm.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = -1619441803996551519L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename = request.getPathInfo().substring(1);
		File folder = new File(Constants.UPLOADEDIMAGESPATH);

		if (!folder.exists()) {
			try {
				folder.mkdirs();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		try {
			File file = new File(Constants.UPLOADEDIMAGESPATH, filename);
			if (filename != null && filename.length() > 0) {
				response.setHeader("Content-Type", getServletContext().getMimeType(filename));
				response.setHeader("Content-Length", String.valueOf(file.length()));
				response.setHeader("Content-Disposition", "inline; filename=\"" + filename + "\"");
				Files.copy(file.toPath(), response.getOutputStream());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
