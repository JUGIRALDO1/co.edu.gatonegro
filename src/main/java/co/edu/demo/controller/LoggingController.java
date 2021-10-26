package co.edu.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.demo.model.dto.ContactDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LoggingController {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @RequestMapping("/")
    public String index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "Howdy! Check out the Logs to see the output...";
    }

    @GetMapping("/info")
    public ResponseEntity<ContactDTO> getInfo() {
        logger.info("An INFO Message");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/debug")
    public ResponseEntity<ContactDTO> getDebug() {
        logger.debug("An DEBUG Message");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/trace")
    public ResponseEntity<ContactDTO> getTrace() {
        logger.trace("An TRACE Message");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/warn")
    public ResponseEntity<ContactDTO> getWarn() {
        logger.trace("An WARN Message");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/error2")
    public ResponseEntity<ContactDTO> getError2() {
        logger.error("An ERROR 2 Message");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}