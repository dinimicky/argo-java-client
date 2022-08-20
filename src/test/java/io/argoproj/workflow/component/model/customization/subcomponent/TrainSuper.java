package io.argoproj.workflow.component.model.customization.subcomponent;

import java.util.Map;

/**
 * @author ezonghu
 * @date 2022/08/20
 */
public class TrainSuper {

    private String sparseFeatureConfigFile;

    private String datasetPrefetchBufferSize;

    private String datasetNumParallelCalls;

    private Integer datasetBatchSize = 256;

    private Integer datasetShuffleBufferSize = 10000;

    private Boolean useTestDataForEvaluator;

    private Map<String, String> customParams;
}
