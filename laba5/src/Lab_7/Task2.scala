package Lab_7

class Task2 {

  def task(typeOfNotification: String, firstParam: String, secondParam: String, thirdParam: String = ""): String = {

    abstract class Notification
    case class Email(sender: String, title: String, body: String) extends Notification
    case class SMS(caller: String, message: String) extends Notification
    case class VoiceRecording(contactName: String, link: String) extends Notification

    typeOfNotification match {
      case "Email" => GetStringOfNotif(Email(firstParam, secondParam, thirdParam))
      case "SMS" => GetStringOfNotif(SMS(firstParam, secondParam))
      case "VoiceRecording" => GetStringOfNotif(VoiceRecording(firstParam, secondParam))
      case _ => "Incorrect type of notification"
    }

    def GetStringOfNotif(notif: Notification): String = {
      notif match{
        case Email(sender, title, body) => "New email! Sender: %s. Title: %s. Body: %s".format(sender, title, body)
        case SMS(caller, message) => "New sms! Caller: %s. Message: %s".format(caller, message)
        case VoiceRecording(contactName, link) => "New voice recording! Contact name: %s. Link: %s".format(contactName, link)
      }
    }

  }

}
