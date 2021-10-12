package sb.com.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sb.com.project.controllers.GroupController;
import sb.com.project.services.GroupService;

@Configuration
@ConditionalOnClass({GroupController.class})
public class GroupControllerConfig {

    @Bean(name = "groupService")
    @ConditionalOnMissingBean
    public GroupService getGroupService(){
        return new GroupService();
    }
}
