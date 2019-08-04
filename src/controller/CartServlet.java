package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.ItemsDAOImpl;
import entity.Cart;
import entity.Items;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String action;
	private ItemsDAOImpl idao = new ItemsDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		if (request.getParameter("action")!=null) {
			this.action = request.getParameter("action");
			if (action.equals("add")) {
				if (addToCart(request,response)) {
					request.getRequestDispatcher("/success.jsp").forward(request, response);;

				}else{
					request.getRequestDispatcher("/failure.jsp").forward(request, response);
				}

			}
			if(action.equals("show")){
				request.getRequestDispatcher("/cart.jsp").forward(request, response);
			}


			if(action.equals("delete")){
				if (deleteToCart(request,response)) {
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				}
			}
			
			if (action.equals("pay")) {
				request.getRequestDispatcher("/pay.jsp").forward(request, response);
			}


		}
	}


	//添加商品
	private boolean addToCart(HttpServletRequest request, HttpServletResponse response) {
		String id= request.getParameter("id");
		String number = request.getParameter("num");
		Items item = idao.getItemsById(Integer.parseInt(id));

		//判断商品是否是第一次添加到购物车,需要给session中创建一个新的对象
		if(request.getSession().getAttribute("cart")==null){
			Cart cart = new Cart();
			request.getSession().setAttribute("cart",cart);
		}
		Cart cart = (Cart) request.getSession().getAttribute("cart");

		if (cart.addGoodsInCart(item, Integer.parseInt(number))) {
			return true;
		}else{
			return false;
		}

	}

	//删除商品
	private boolean deleteToCart(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Items items = idao.getItemsById(Integer.parseInt(id));
		Cart cart = (Cart) request.getSession().getAttribute("cart");


		if (cart.removeGoodsInCart(items)) {
			return true;
		}else{

			return false;
		}
	}

}
