package io.argoproj.workflow.component.model;

import java.time.LocalDateTime;

/**
 * @author kaiji
 * @version 1.0.0
 * @ClassName BaseStatus.java
 * @Description TODO
 * @date 2022/8/18 22:42
 */
public class BaseStatus {

    private String id;

    private String phase;

    private LocalDateTime startedAt;

    private LocalDateTime finishedAt;
}
