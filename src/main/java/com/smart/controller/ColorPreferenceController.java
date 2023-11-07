package com.smart.controller;

@RestController
public class ColorPreferenceController {

    private final ColorPreferenceRepository colorPreferenceRepository;

    public ColorPreferenceController(ColorPreferenceRepository colorPreferenceRepository) {
        this.colorPreferenceRepository = colorPreferenceRepository;
    }

    @PostMapping("/color-preferences")
    public ColorPreference createColorPreference(@RequestBody ColorPreference colorPreference) {
        return colorPreferenceRepository.save(colorPreference);
    }

    @GetMapping("/color-preferences/{id}")
    public ColorPreference getColorPreference(@PathVariable Long id) {
        return colorPreferenceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Color preference not found"));
    }

    @PutMapping("/color-preferences/{id}")
    public ColorPreference updateColorPreference(@PathVariable Long id, @RequestBody ColorPreference colorPreference) {
        colorPreference.setId(id);
        return colorPreferenceRepository.save(colorPreference);
    }

    @DeleteMapping("/color-preferences/{id}")
    public void deleteColorPreference(@PathVariable Long id) {
        colorPreferenceRepository.deleteById(id);
    }
}
