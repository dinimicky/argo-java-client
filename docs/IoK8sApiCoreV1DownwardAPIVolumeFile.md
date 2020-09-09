

# IoK8sApiCoreV1DownwardAPIVolumeFile

DownwardAPIVolumeFile represents information to create the file containing the pod field
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**fieldRef** | [**IoK8sApiCoreV1ObjectFieldSelector**](IoK8sApiCoreV1ObjectFieldSelector.md) |  |  [optional]
**mode** | **Integer** | Optional: mode bits to use on this file, must be a value between 0 and 0777. If not specified, the volume defaultMode will be used. This might be in conflict with other options that affect the file mode, like fsGroup, and the result can be other mode bits set. |  [optional]
**path** | **String** | Required: Path is  the relative path name of the file to be created. Must not be absolute or contain the &#39;..&#39; path. Must be utf-8 encoded. The first item of the relative path must not start with &#39;..&#39; | 
**resourceFieldRef** | [**IoK8sApiCoreV1ResourceFieldSelector**](IoK8sApiCoreV1ResourceFieldSelector.md) |  |  [optional]


