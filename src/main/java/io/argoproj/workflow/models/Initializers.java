/*
 * Argo
 * Argo
 *
 * The version of the OpenAPI document: v2.10.0-rc3
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.argoproj.workflow.models;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.argoproj.workflow.models.Initializer;
import io.argoproj.workflow.models.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Initializers tracks the progress of initialization.
 */
@ApiModel(description = "Initializers tracks the progress of initialization.")

public class Initializers {
  public static final String SERIALIZED_NAME_PENDING = "pending";
  @SerializedName(SERIALIZED_NAME_PENDING)
  private List<Initializer> pending = new ArrayList<Initializer>();

  public static final String SERIALIZED_NAME_RESULT = "result";
  @SerializedName(SERIALIZED_NAME_RESULT)
  private Status result;


  public Initializers pending(List<Initializer> pending) {
    
    this.pending = pending;
    return this;
  }

  public Initializers addPendingItem(Initializer pendingItem) {
    this.pending.add(pendingItem);
    return this;
  }

   /**
   * Pending is a list of initializers that must execute in order before this object is visible. When the last pending initializer is removed, and no failing result is set, the initializers struct will be set to nil and the object is considered as initialized and visible to all clients.
   * @return pending
  **/
  @ApiModelProperty(required = true, value = "Pending is a list of initializers that must execute in order before this object is visible. When the last pending initializer is removed, and no failing result is set, the initializers struct will be set to nil and the object is considered as initialized and visible to all clients.")

  public List<Initializer> getPending() {
    return pending;
  }


  public void setPending(List<Initializer> pending) {
    this.pending = pending;
  }


  public Initializers result(Status result) {
    
    this.result = result;
    return this;
  }

   /**
   * Get result
   * @return result
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Status getResult() {
    return result;
  }


  public void setResult(Status result) {
    this.result = result;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Initializers initializers = (Initializers) o;
    return Objects.equals(this.pending, initializers.pending) &&
        Objects.equals(this.result, initializers.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pending, result);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Initializers {\n");
    sb.append("    pending: ").append(toIndentedString(pending)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
