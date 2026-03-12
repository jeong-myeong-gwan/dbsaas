package mj.dbsaas.security;

import mj.dbsaas.repository.AgentDAO;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.WebApplicationContext;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("tokenAuthFilter")
@RequiredArgsConstructor
public class TokenAuthFilter implements Filter {

    private final AgentDAO agentDAO;

    @Override
    public void init(FilterConfig filterConfig) {  
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String uri = req.getServletPath();

        if (uri.startsWith("/api/events")) {

            String auth = req.getHeader("Authorization");

            if (auth == null || !auth.startsWith("Bearer ")) {
                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                resp.getWriter().write("Missing token");
                return;
            }

            String token = auth.substring(7);

            boolean valid = agentDAO.existsByToken(token);

            if (!valid) {
                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                resp.getWriter().write("Invalid token");
                return;
            }
        }

        chain.doFilter(request, response);
    }
}