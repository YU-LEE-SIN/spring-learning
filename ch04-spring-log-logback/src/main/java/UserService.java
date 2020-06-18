import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yu
 * @date 2020/5/17
 */
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public void query(){
        logger.trace("query in UserService");
        logger.debug("query in UserService");
        logger.info("query in UserService");
        logger.warn("query in UserService");
    }
}
