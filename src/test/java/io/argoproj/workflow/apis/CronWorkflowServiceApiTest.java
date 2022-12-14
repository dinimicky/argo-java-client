/*
 * Argo Server API
 * You can get examples of requests and responses by using the CLI with `--gloglevel=9`, e.g. `argo list --gloglevel=9`
 *
 * The version of the OpenAPI document: v2.12.2
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.argoproj.workflow.apis;

import io.argoproj.workflow.ApiException;
import io.argoproj.workflow.models.CreateCronWorkflowRequest;
import io.argoproj.workflow.models.CronWorkflow;
import io.argoproj.workflow.models.CronWorkflowList;
import io.argoproj.workflow.models.CronWorkflowResumeRequest;
import io.argoproj.workflow.models.CronWorkflowSuspendRequest;
import io.argoproj.workflow.models.LintCronWorkflowRequest;
import io.argoproj.workflow.models.UpdateCronWorkflowRequest;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CronWorkflowServiceApi
 */
@Ignore
public class CronWorkflowServiceApiTest {

    private final CronWorkflowServiceApi api = new CronWorkflowServiceApi();

    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createCronWorkflowTest() throws ApiException {
        String namespace = null;
        CreateCronWorkflowRequest body = null;
        CronWorkflow response = api.createCronWorkflow(namespace, body);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteCronWorkflowTest() throws ApiException {
        String namespace = null;
        String name = null;
        String deleteOptionsGracePeriodSeconds = null;
        String deleteOptionsPreconditionsUid = null;
        String deleteOptionsPreconditionsResourceVersion = null;
        Boolean deleteOptionsOrphanDependents = null;
        String deleteOptionsPropagationPolicy = null;
        List<String> deleteOptionsDryRun = null;
        Object response = api.deleteCronWorkflow(namespace, name, deleteOptionsGracePeriodSeconds, deleteOptionsPreconditionsUid, deleteOptionsPreconditionsResourceVersion, deleteOptionsOrphanDependents, deleteOptionsPropagationPolicy, deleteOptionsDryRun);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getCronWorkflowTest() throws ApiException {
        String namespace = null;
        String name = null;
        String getOptionsResourceVersion = null;
        CronWorkflow response = api.getCronWorkflow(namespace, name, getOptionsResourceVersion);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lintCronWorkflowTest() throws ApiException {
        String namespace = null;
        LintCronWorkflowRequest body = null;
        CronWorkflow response = api.lintCronWorkflow(namespace, body);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listCronWorkflowsTest() throws ApiException {
        String namespace = null;
        String listOptionsLabelSelector = null;
        String listOptionsFieldSelector = null;
        Boolean listOptionsWatch = null;
        Boolean listOptionsAllowWatchBookmarks = null;
        String listOptionsResourceVersion = null;
        String listOptionsTimeoutSeconds = null;
        String listOptionsLimit = null;
        String listOptionsContinue = null;
        CronWorkflowList response = api.listCronWorkflows(namespace, listOptionsLabelSelector, listOptionsFieldSelector, listOptionsWatch, listOptionsAllowWatchBookmarks, listOptionsResourceVersion, listOptionsTimeoutSeconds, listOptionsLimit, listOptionsContinue);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void resumeCronWorkflowTest() throws ApiException {
        String namespace = null;
        String name = null;
        CronWorkflowResumeRequest body = null;
        CronWorkflow response = api.resumeCronWorkflow(namespace, name, body);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void suspendCronWorkflowTest() throws ApiException {
        String namespace = null;
        String name = null;
        CronWorkflowSuspendRequest body = null;
        CronWorkflow response = api.suspendCronWorkflow(namespace, name, body);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateCronWorkflowTest() throws ApiException {
        String namespace = null;
        String name = null;
        UpdateCronWorkflowRequest body = null;
        CronWorkflow response = api.updateCronWorkflow(namespace, name, body);

        // TODO: test validations
    }
    
}
