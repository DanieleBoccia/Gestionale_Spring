package MySpringInitializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import MySpringConfig.MyWebConfig;
import MySpringConfig.PersistenceJpaConfig;

public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
   
   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class[] { MyWebConfig.class };
   }
   
   @Override
   protected String[] getServletMappings() {
      return new String[] { "/" };
   }

   @Override
   protected Class<?>[] getRootConfigClasses() {
	   
	  return new Class[] {
			  PersistenceJpaConfig.class
	  };
   
   }
}
