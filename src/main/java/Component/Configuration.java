package Component;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


import General.*;

@Component
@Configuration
@EnableScheduling
@ConditionalOnProperty(name="scheduling.enables", matchIfMissing=true)
class SchedulingCOnfiguration {
	
}

