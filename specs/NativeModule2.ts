import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';

export interface Spec extends TurboModule {
    masti(): string;
}

export default TurboModuleRegistry.getEnforcing<Spec>(
    'NativeModule2',
)