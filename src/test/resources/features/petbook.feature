Feature: petbook
  As a web user
  I want to access to PetBook web application
  So I can see the list of images

  Scenario: First pick an image, then apply the gato filter
    When Goku selects the "Gato" filter
    Then The results should show "2" elements

  Scenario: First apply the perro filter, then pick an image
    When Goku selects the "Perro" filter, then picks an image of "perro"
    Then The image should be displayed in real size

  Scenario: All images
    When Goku selects the "Gato" filter
    And after that he changes to the "Perro" filter
    Then selects the "All" filter, all images should be displayed