package io.argoproj.workflow.component.model.customization.subcomponent;

/**
 * @author kaiji
 * @version 1.0.0
 * @ClassName Resource.java
 * @Description TODO
 * @date 2022/2/16 4:47 PM
 */
public class Resource {

    Integer replicas;

    Integer cpu;

    String mem;

    Integer gpu;

    String gpuKey = "nvidia.com/gpu";
}
