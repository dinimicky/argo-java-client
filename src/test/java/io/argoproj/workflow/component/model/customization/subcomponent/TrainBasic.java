package io.argoproj.workflow.component.model.customization.subcomponent;

/**
 * @version 1.0.0
 * @ClassName TrainBasic.java * @author zhangqing1
 * @Description TODO
 * @date 2022/5/23 11:32 PM
 */
public class TrainBasic {

    private String gitAddr;

    private String gitBranch;

    private String gitCommitId;

    private String modelEntryPoint = "main.py"; // 支持指定模型训练入口文件，默认是main.py

    private String modelConfigDir;

    // larc base image tag
    private String larcBaseImageTag;

    // larc version to reinstall in larc base image
    private String larcVersion;

    private String multiTaskModels;

    private String modelWeightBoost;

    private Integer trainDataRounds;

}
