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


package io.argoproj.workflow.models;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.argoproj.workflow.models.DownwardAPIVolumeFile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents downward API info for projecting into a projected volume. Note that this is identical to a downwardAPI volume source without the default mode.
 */
@ApiModel(description = "Represents downward API info for projecting into a projected volume. Note that this is identical to a downwardAPI volume source without the default mode.")

public class DownwardAPIProjection {
  public static final String SERIALIZED_NAME_ITEMS = "items";
  @SerializedName(SERIALIZED_NAME_ITEMS)
  private List<DownwardAPIVolumeFile> items = null;


  public DownwardAPIProjection items(List<DownwardAPIVolumeFile> items) {
    
    this.items = items;
    return this;
  }

  public DownwardAPIProjection addItemsItem(DownwardAPIVolumeFile itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<DownwardAPIVolumeFile>();
    }
    this.items.add(itemsItem);
    return this;
  }

   /**
   * Items is a list of DownwardAPIVolume file
   * @return items
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Items is a list of DownwardAPIVolume file")

  public List<DownwardAPIVolumeFile> getItems() {
    return items;
  }


  public void setItems(List<DownwardAPIVolumeFile> items) {
    this.items = items;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DownwardAPIProjection downwardAPIProjection = (DownwardAPIProjection) o;
    return Objects.equals(this.items, downwardAPIProjection.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DownwardAPIProjection {\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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

