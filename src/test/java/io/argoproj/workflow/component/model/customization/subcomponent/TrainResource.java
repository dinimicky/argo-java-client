package io.argoproj.workflow.component.model.customization.subcomponent;

import java.util.Map;

/**
 * @author ezonghu
 * @date 2022/08/20
 */
public class TrainResource {

    private String resourceAccount;

    private String resourceQueue;

    private String clusterTag;

    private Boolean isPsNotSameNode;

    private Resource ps;

    private Resource worker;

    private Map<String, String> extraResourceArgs;

    private Map<String, String> extraEnvArgs;
}
