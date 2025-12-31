package com.riderent.riderent.controller;



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Apne DAO aur Connection provider ko import karo
// (Dhyan dein: Agar tumhare package ka naam alag hai toh use badal lena)
import com.riderent.riderent.Doa.UserDAO;
import com.riderent.riderent.model.User;
import com.riderent.riderent.Doa.*; // Agar ConnectionProvider alag class hai

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 1. Browser se data nikalo
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // 2. UserDao ka object banao
            // (Main maan ke chal raha hu ki tumne ConnectionProvider banaya hai. 
            // Agar nahi banaya, toh DAO ke constructor mein connection kaise pass kar rahe ho wo check karna)
            UserDAO dao = new UserDAO();

            // 3. DAO wala login method call karo
            // (Tumhare method ka naam 'getUserByEmailAndPassword' ya 'login' ho sakta hai, use yahan likhna)
            User user = dao.loginUser(email, password);

            if(user != null) {
                // === LOGIN SUCCESS ===
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", user); // Pura user object session mein rakho
                
                response.sendRedirect("index.jsp");
            } else {
                // === LOGIN FAILED ===
                out.println("<h3 style='color:red; text-align:center;'>Email or Password Galat hai!</h3>");
                request.getRequestDispatcher("login.jsp").include(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3 style='color:red'>Error: " + e.getMessage() + "</h3>");
        }
    }
}