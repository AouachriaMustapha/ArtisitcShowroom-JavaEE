package esprit.ArtisticShowroom.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esprit.ArtisticShowroom.persistence.User;
import esprit.ArtisticShowroom.presentation.mbeans.AuthentificationBean;



@WebFilter("/userManage/*")
public class AdminFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		
		HttpServletRequest request = (HttpServletRequest) srequest;
		HttpServletResponse response = (HttpServletResponse) sresponse;
		
		AuthentificationBean auth =(AuthentificationBean) request.getSession().getAttribute("authBean");
		if(auth!= null && auth.isLoggedIn() ){
			chain.doFilter(request, response);
		}else
		{
			auth.setUser(new User());
			response.sendRedirect(request.getContextPath() + "/public/authentification.jsf");
		}
		
		
	}

	@Override
	public void destroy() {

		
	}
	
	

}
