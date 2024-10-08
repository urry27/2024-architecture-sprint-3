resource "helm_release" "device_management" {
  name       = "device-management"
  namespace  = "default"
  chart      = "../charts/device-management"
}

resource "helm_release" "telemetry" {
  name       = "telemetry"
  namespace  = "default"
  chart      = "../charts/telemetry"
}

