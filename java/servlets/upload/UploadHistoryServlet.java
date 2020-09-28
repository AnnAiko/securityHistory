package servlets.upload;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import marshaling.Marsh;

@WebServlet("/UploadHistoryServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2)
public class UploadHistoryServlet extends HttpServlet {

    private static final String SAVE_DIR = "uploadFiles";

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        //Получить к путь к web-приложению
        String appPath = request.getServletContext().getRealPath("");
        //Получить путь к каталогу для сохранения файла
        String savePath = appPath + File.separator + SAVE_DIR;
        //Создать каталог если он не существует
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            fileName = new File(fileName).getName();
            part.write(savePath + File.separator + fileName);
            Marsh marsh = new Marsh();
            marsh.unmarchHistory(savePath + File.separator + fileName);
        }
        request.setAttribute("message", "Upload has been done successfully!");
        request.getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
    }

    /* Получить имя файла из заголовка HTTP */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
