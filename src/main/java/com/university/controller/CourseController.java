@Controller
public class CourseController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/courses")
    public String showCourses(Model model) {

        List<Map<String, Object>> list = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();

            ResultSet rs = conn.createStatement()
                    .executeQuery("SELECT * FROM courses");

            while (rs.next()) {
                Map<String, Object> c = new HashMap<>();
                c.put("id", rs.getInt("course_id"));
                c.put("name", rs.getString("name"));
                c.put("instructor", rs.getString("instructor"));
                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("courses", list);
        return "courses";
    }