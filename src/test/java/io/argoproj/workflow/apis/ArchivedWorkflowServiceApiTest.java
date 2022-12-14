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
import io.argoproj.workflow.models.Workflow;
import io.argoproj.workflow.models.WorkflowList;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ArchivedWorkflowServiceApi
 */
@Ignore
public class ArchivedWorkflowServiceApiTest {

    private final ArchivedWorkflowServiceApi api = new ArchivedWorkflowServiceApi();

    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteArchivedWorkflowTest() throws ApiException {
        String uid = null;
        Object response = api.deleteArchivedWorkflow(uid);

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
    public void getArchivedWorkflowTest() throws ApiException {
        String uid = null;
        Workflow response = api.getArchivedWorkflow(uid);

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
    public void listArchivedWorkflowsTest() throws ApiException {
        String listOptionsLabelSelector = null;
        String listOptionsFieldSelector = null;
        Boolean listOptionsWatch = null;
        Boolean listOptionsAllowWatchBookmarks = null;
        String listOptionsResourceVersion = null;
        String listOptionsTimeoutSeconds = null;
        String listOptionsLimit = null;
        String listOptionsContinue = null;
        WorkflowList response = api.listArchivedWorkflows(listOptionsLabelSelector, listOptionsFieldSelector, listOptionsWatch, listOptionsAllowWatchBookmarks, listOptionsResourceVersion, listOptionsTimeoutSeconds, listOptionsLimit, listOptionsContinue);

        // TODO: test validations
    }
    
}
