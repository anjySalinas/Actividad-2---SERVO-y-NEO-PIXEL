from machine import Pin, PWM
from neopixel import NeoPixel
import utime

def map_angle(x):
# Mapea el ángulo (0-180) al ciclo de trabajo PWM (40-115)
return int((x - 0) * (115 - 40) / (180 - 0) + 40)

def main():
# Inicializa el motor servo en el pin 14 con PWM a 50Hz
servo = PWM(Pin(13), freq=50) # Usa el pin 14

# Colores del arco iris para los NeoPixels
rainbow = [
(255, 255, 255), (114, 13, 0), (102, 25, 0), (90, 37, 0), (78, 49, 0),
(66, 61, 0), (54, 73, 0), (42, 85, 0), (30, 97, 0), (18, 109, 0),
(6, 121, 0), (0, 122, 5), (0, 110, 17), (0, 98, 29), (0, 86, 41), (42, 85, 0)
]

# Inicializa el strip de NeoPixels en el pin 15 con 16 LEDs
pixels = NeoPixel(Pin(15), 16)

# Inicialización de temporizadores
last_update = utime.ticks_ms() # Tiempo para ambos, servo y NeoPixels

# Variables para el ángulo del servo y la dirección
angulo = 0
moving_forward = True # Para controlar la dirección del servo

while True:
# Verifica si han pasado 50ms (sin bloquear)
if utime.ticks_ms() - last_update >= 50:
# Movimiento del servo
if moving_forward:
angulo += 10
if angulo >= 180:
angulo = 180
moving_forward = False # Cambiar dirección cuando llega a 180 grados
else:
angulo -= 10
if angulo <= 0:
angulo = 0
moving_forward = True # Cambiar dirección cuando llega a 0 grados

# Mapea el ángulo del servo (0-180) al valor PWM
m = map_angle(angulo)
servo.duty(m) # Establece el ciclo de trabajo del servo

# Sincronización del ángulo con el color de los NeoPixels
color_index = angulo // 12 # Mapea el ángulo a un índice entre 0 y 15
target_angle = color_index * 12 # El ángulo objetivo será múltiplo de 12

# Simulación del barrido de los colores de los NeoPixels
if moving_forward:
rainbow = rainbow[-1:] + rainbow[:-1] # Rota los colores hacia adelante
else:
rainbow = rainbow[1:] + rainbow[:1] # Rota los colores hacia atrás

# Asigna los colores a los NeoPixels
for i in range(16):
pixels[i] = rainbow[i] # Asigna cada color a un NeoPixel
pixels.write() # Actualiza la tira de NeoPixels

last_update = utime.ticks_ms() # Reinicia el temporizador para la próxima actualización

if __name__ == "__main__":
main()
