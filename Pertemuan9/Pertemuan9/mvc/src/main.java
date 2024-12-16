package Pertemuan9.Pertemuan9.mvc.src;

import Pertemuan9.Pertemuan9.mvc.src.model.MyBatisUtil;
import Pertemuan9.Pertemuan9.mvc.src.model.UserMapper;
import org.apache.ibatis.session.SqlSession;
import Pertemuan9.Pertemuan9.mvc.src.view.UserView;
import Pertemuan9.Pertemuan9.mvc.src.controller.UserController;

public class main {
  public static void main(String[] args) {
    SqlSession session = MyBatisUtil.getSqlSession();
    UserMapper mapper = session.getMapper(UserMapper.class);

    UserView view = new UserView();
    new UserController(view, mapper);

    view.setVisible(true);
  }
}
