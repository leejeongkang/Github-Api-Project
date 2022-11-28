import BaseRadio from "./base-radio.vue";

export default {
  title: 'Styled/Atoms/[PCFC] 라디오',
  components: BaseRadio,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 20px; font-size: 20px; color: #212121;">(예시) Radio Input Element </h2><div style="display: flex; flex-direction: row; "><story /></div></div>',
    }),
  ],
};

export const Default = () => ({
  components: { BaseRadio },
  template:
    `
      <div class="radios">
      <BaseRadio name="radio-test" radioId="radio-01"><template v-slot:label>Basic Radio</template></BaseRadio>
      <BaseRadio name="radio-test" radioId="radio-02"><template v-slot:label>Basic Radio</template></BaseRadio>
      <BaseRadio name="radio-test" radioId="radio-03"><template v-slot:label>Basic Radio</template></BaseRadio>
      </div>
    `,
});

export const RadioSwitch = () => ({
  components: { BaseRadio },
  template:
    `<div class="radio-switch">
    <BaseRadio name="radio-test" radioId="radio1"><template v-slot:label>Radio1</template></BaseRadio>
    <BaseRadio name="radio-test" radioId="radio2"><template v-slot:label>Radio2</template></BaseRadio>
    <BaseRadio name="radio-test" radioId="radio3"><template v-slot:label>Radio3</template></BaseRadio>
    </div>`,
});

export const RadioSwitchIcon = () => ({
  components: { BaseRadio },
  template:
    `<div class="radio-switch radio-switch--icon">
      <BaseRadio name="radio-test" radioId="radio01"><template v-slot:label><svg-icon class="svg-icon radio__icon" name="app-switcher" aria-hidden="true"></svg-icon><span class="hidden">카드형</span></template></BaseRadio>
      <BaseRadio name="radio-test" radioId="radio02"><template v-slot:label><svg-icon class="svg-icon radio__icon" name="menu" aria-hidden="true"></svg-icon><span class="hidden">카드형</span></template></BaseRadio>
      <BaseRadio name="radio-test" radioId="radio03"><template v-slot:label><svg-icon class="svg-icon radio__icon" name="app-switcher" aria-hidden="true"></svg-icon><span class="hidden">카드형</span></template></BaseRadio>
      <BaseRadio name="radio-test" radioId="radio02"><template v-slot:label><svg-icon class="svg-icon radio__icon" name="menu" aria-hidden="true"></svg-icon><span class="hidden">카드형</span></template></BaseRadio>
    </div>`,
});
