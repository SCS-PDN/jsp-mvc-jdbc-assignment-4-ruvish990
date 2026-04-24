@Controller
public class LoginController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String email, String password,
                        HttpSession session, Model model) {

        try {
            Connection conn = dataSource.getConnection();

            String sql = "SELECT * FROM students WHERE email=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                session.setAttribute("studentId", rs.getInt("student_id"));
                return "redirect:/courses";
            } else {
                model.addAttribute("error", "Wrong email or password");
                return "login";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "login";
        }
    }
}