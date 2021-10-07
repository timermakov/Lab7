<?php

session_start();
$start = microtime(true); // Время начала исполнения скрипта
$validX = array(-2, -1.5, -1, -0.5, 0, 0.5, 1, 1.5, 2);
$r = floatval(htmlspecialchars($_POST["r"]));
$x = floatval(htmlspecialchars($_POST["x"]));
$y = floatval(htmlspecialchars($_POST["y"]));
date_default_timezone_set("Europe/Moscow");
$current_time = date("H:i:s");
$message = "";
$class = "No";

$int_value = is_numeric($r) ? floatval($r) : null;
if ($int_value === null)
{
// $value wasn't all numeric
}

$int_value = is_numeric($y) ? floatval($y) : null;
if ($int_value === null)
{
// $value wasn't all numeric
}

if ((($x <= 0 && $y <= 0 && ($x*$x+$y*$y) <= $r*$r)) ||
     ($x >= 0 && $y >= 0 && ($y <= -$x/2 + $r/2)) ||
     ($x <= 0 && $y >= 0 && $x >= -$r && $y <= $r/2)) {
  $message = "Yes";
  $class = "Yes";
} else {
  $message = "No";
}

if (!is_null($r) && !is_null($x) && !is_null($y)) {
  if ($r == 0 && $x == 0 && $y == 0) {
    $message = "Insert Data";
  } else {
    if ($r > 4 || $r < 1) {
      $message = "Invalid R";
    }
    if (!in_array($x, $validX)) {
      $message = "Invalid X";
    }
    if ($y > 3 || $y < -5) {
      $message = "Invalid Y";
    }
  }

  $time = strval(number_format(microtime(true) - $start, 9, ".", "")*1000) . ' ms';

  // Сохранение в сессию
  $result = array($x, $y, $r, $message, $time, $current_time);
  if (!isset($_SESSION['results'])) {
    $_SESSION['results'] = array();
  }
  array_push($_SESSION['results'], $result);

  // Печать в таблицу
  print_r('<tr><td>'.$x.'</td><td>'.$y.'</td><td>'.$r.'</td><td class="'.$class.'">'.$message.'</td><td>'.$time.'</td><td>'.$current_time.'</td></tr>');

}

?>
