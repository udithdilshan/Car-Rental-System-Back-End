package lk.easycarrental.carrentalsystem.utill;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;

public class CustomMutlipartResolver extends CommonsMultipartResolver {

    @Override
    public boolean isMultipart(HttpServletRequest request) {

        if (request.getMethod().equals("PUT") || request.getMethod().equals("POST")){
            return true;
        }else {
            return super.isMultipart(request);
        }

    }
}
